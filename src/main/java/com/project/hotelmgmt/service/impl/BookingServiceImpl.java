package com.project.hotelmgmt.service.impl;

import com.project.hotelmgmt.dao.BookingDao;
import com.project.hotelmgmt.dao.RoomDao;
import com.project.hotelmgmt.dto.BookingDTO;
import com.project.hotelmgmt.dto.CustomerDTO;
import com.project.hotelmgmt.entity.BookingEntity;
import com.project.hotelmgmt.entity.HotelEntity;
import com.project.hotelmgmt.entity.RoomEntity;
import com.project.hotelmgmt.entity.UserEntity;
import com.project.hotelmgmt.exceptions.BookingNotFoundException;
import com.project.hotelmgmt.exceptions.RequirementsUnavailableException;
import com.project.hotelmgmt.exceptions.UserNotFoundException;
import com.project.hotelmgmt.service.BookingService;
import com.project.hotelmgmt.util.EntityDTOConvert;
import com.project.hotelmgmt.util.UtilData;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor

public class BookingServiceImpl implements BookingService {
    private final BookingDao bookingDao;
    private final EntityDTOConvert entityDTOConvert;
    private final CustomerServiceImpl customerServiceImpl;
    private final RoomDao roomDao;

    @PostConstruct
    public  void initializeBookingAvailability() {
        updateBookingAvailability();
    }// not finished

    @Override
    public void updateBookingAvailability(){
        LocalDate today = LocalDate.now();

        List<BookingEntity> bookings = bookingDao.findByIsBookingAvailableTrueAndCheckOutDateBefore(today);
        if(bookings == null || bookings.isEmpty()){
            return;
        }
        for(BookingEntity booking : bookings){
            if(booking.getCheckOutDate().isBefore(today)) {
                booking.setIsBookingAvailable(false);

                List<RoomEntity> rooms = booking.getRooms();
                for(RoomEntity room :rooms) {
                    room.setRoomAvailable(true);
                    roomDao.save(room);
                }
                bookingDao.save(booking);
                // free the room
            }
        }
    }


    @Override
    public void addBooking(BookingDTO bookingDTO) {

        if (bookingDTO!=null){
            if(bookingDTO.getCheckInDate().isBefore(UtilData.generateTodayDate())){
                throw new RequirementsUnavailableException("Checking date must be after the current date.");
            }
            bookingDTO.setBookingID(UtilData.generateBookingId());
            //check whether the room is available
            Map<String,Long> roomTypes_Count= new HashMap<>();
            roomTypes_Count=bookingDao.getCountByRoomType(bookingDTO.getHotelId());
            //roomTypes.get()
            for(String roomType:bookingDTO.getRoomType().keySet()){

                if(bookingDTO.getRoomType().get(roomType) == null || bookingDTO.getRoomType().get(roomType) == 0){
                    continue;
                }

                if((long)bookingDTO.getRoomType().get(roomType)>roomTypes_Count.get(roomType)){
                    System.out.println("Insufficient amount of room.");
                    return;
                }
            }
            System.out.println("Rooms are available.");

            List<RoomEntity> selectedRooms = new ArrayList<>();

            for(String roomType:bookingDTO.getRoomType().keySet()) {

                List<RoomEntity> rooms = new ArrayList<>();
                rooms =  bookingDao.roomByHotelAndRoomType(bookingDTO.getHotelId(),roomType);

                Integer requestedCountByRoomType = bookingDTO.getRoomType().get(roomType);

                if( requestedCountByRoomType == null || requestedCountByRoomType == 0){
                    continue;
                }

                for(int i=0;i<requestedCountByRoomType;i++){
                    RoomEntity roomEntity = rooms.get(i);

                    roomEntity.setRoomAvailable(false);
                    roomDao.save(roomEntity);

                    selectedRooms.add(roomEntity);
                }
            }
            BookingEntity bookingEntity = entityDTOConvert.convertBookingDTOToBookingEntity(bookingDTO);
            bookingEntity.setRooms(selectedRooms);
            bookingEntity.setIsBookingAvailable(true);

            System.out.println("Booking successfully created");
            System.out.println(bookingDTO);
        }else{

            /*customerServiceImpl.addCustomer(customerDTO);*/


            System.out.println("BookingDTO is null");
        }
    }
    /*
    Authentication authentication =
            SecurityContextHolder.getContext().getAuthentication();


    UserEntity user = userDao.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

    CustomerEntity customer = user.getCustomer();

if (customer == null) {
        customer = customerService.addCustomer(customerDTO, user);
    }

bookingEntity.setCustomer(customer);



    public CustomerEntity addCustomer(CustomerDTO customerDTO, UserEntity user) {

        // create customer
        CustomerEntity customerEntity =
                entityDTOConvert.convertCustomerDTOToCustomerEntity(customerDTO);

        customerEntity.setUser(user);

        return customerDao.save(customerEntity);
    }*/

    @Override
    public void updateBooking(String bookingID, BookingDTO bookingDTO) {
        System.out.println("from booking service updateBooking method");
        BookingEntity bookingEntity = bookingDao.findById(bookingID).orElseThrow(() -> new BookingNotFoundException("Booking Not Found"));

        if(bookingDTO.getCheckInDate().isBefore(UtilData.generateTodayDate())) {
            throw new RequirementsUnavailableException("Checking date must be after the current date.");
        }
        bookingEntity.setCheckInDate(bookingDTO.getCheckInDate());
        bookingEntity.setCheckOutDate(bookingDTO.getCheckOutDate());
        bookingEntity.setCheckInTime(bookingDTO.getCheckInTime());
        bookingEntity.setCheckOutTime(bookingDTO.getCheckOutTime());
        bookingEntity.setIsBookingAvailable(bookingDTO.getIsBookingAvailable());


        Map<String ,Integer> roomTypes = new HashMap<>();
        roomTypes = bookingDTO.getRoomType();
        List<RoomEntity> selectedRooms = new ArrayList<>();

        if(bookingDTO.getHotelId() ==  bookingEntity.getHotel().getHotelId()){

        }else{
            List<RoomEntity> rooms = bookingEntity.getRooms();
            for(RoomEntity room :rooms) {
                room.setRoomAvailable(true);
                roomDao.save(room);
            }

            for(String roomType : roomTypes.keySet()){
               List<RoomEntity> roomset = new ArrayList<>();
               roomset =bookingDao.roomByHotelAndRoomType(bookingDTO.getHotelId(),roomType);

                    for(int i =0; i<roomTypes.get(roomType);i++){
                        RoomEntity roomEntity =roomset.get(i);
                        roomEntity.setRoomAvailable(false);
                        roomDao.save(roomEntity);
                        selectedRooms.add(roomEntity);
                    }
                }
            bookingEntity.setRooms(selectedRooms);

            }


        bookingDao.save(bookingEntity);
            }





    @Override
    public void deleteBooking(String bookingID) {
        System.out.println("from booking service deleteBooking method");
        BookingEntity bookingEntity = bookingDao.findById(bookingID).orElseThrow(
                () -> new BookingNotFoundException("Booking Not Found")
        );

        List<RoomEntity> rooms = bookingEntity.getRooms();
        for(RoomEntity room :rooms) {
            room.setRoomAvailable(true);
            roomDao.save(room);
        }
        bookingDao.save(bookingEntity);

        bookingDao.delete(bookingEntity);
    }

    @Override
    public BookingDTO getSelectedBooking(String bookingID){
        System.out.println("from booking service getSelectedBooking method");
        BookingEntity bookingEntity = bookingDao.findById(bookingID).orElseThrow(
                () -> new BookingNotFoundException("Booking Not Found")
        );
        BookingDTO bookingDTO = entityDTOConvert.convertBookingEntityToBookingDTO(bookingEntity);

        bookingDTO.setHotelName(bookingEntity.getHotel().getHotelName());
        Map <String ,Integer> roomType = new HashMap<>();
        List<String> roomIdS = new ArrayList<>();
        for (RoomEntity room :bookingEntity.getRooms()){
            String type = room.getRoomType().toString();
            roomIdS.add(room.getRoomId());
            roomType.put(type,roomType.getOrDefault(type,0)+1);
        }
        bookingDTO.setRoomType(roomType);
        bookingDTO.setRoomList(roomIdS);
        return bookingDTO;
    }

    @Override
    public List<BookingDTO> getAllBookings(){
        System.out.println("from booking service getAllBookings method");
        List<BookingEntity> bookingEntityList = bookingDao.findAll();
        List<BookingDTO> bookingDTOS = entityDTOConvert.convertBookingEntityListToBookingDTOList(bookingEntityList);

        for(int i=0;i<bookingDTOS.size();i++){
            BookingDTO bookingDTO = bookingDTOS.get(i);
            BookingEntity bookingEntity = bookingEntityList.get(i);

            bookingDTO.setHotelName(bookingEntity.getHotel().getHotelName());

            Map <String ,Integer> roomTypeMap = new HashMap<>();
            List<String> roomIdS = new ArrayList<>();

            for (RoomEntity room :bookingEntity.getRooms()){
                String type = room.getRoomType().toString();
                roomIdS.add(room.getRoomId());
                roomTypeMap.put(type,roomTypeMap.getOrDefault(type,0)+1);
            }
            bookingDTO.setRoomType(roomTypeMap);
            bookingDTO.setRoomList(roomIdS);
        }
        return bookingDTOS;
    }
}
