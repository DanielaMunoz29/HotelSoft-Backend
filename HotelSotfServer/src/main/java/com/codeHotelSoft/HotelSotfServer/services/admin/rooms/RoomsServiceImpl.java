package com.codeHotelSoft.HotelSotfServer.services.admin.rooms;


import com.codeHotelSoft.HotelSotfServer.dto.RoomDto;
import com.codeHotelSoft.HotelSotfServer.dto.RoomsResponseDto;
import com.codeHotelSoft.HotelSotfServer.entity.Room;
import com.codeHotelSoft.HotelSotfServer.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomsServiceImpl implements RoomsService {


    private final RoomRepository roomRepository;


    public boolean postRoom(RoomDto roomDto) {
        try{
            Room room = new Room();


            room.setName(roomDto.getName());
            room.setPrice(roomDto.getPrice());
            room.setPrice(roomDto.getPrice());
            room.setAvailable(true);


            roomRepository.save(room);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public RoomsResponseDto getAllRooms(int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber, 6);
        Page<Room> roomPage = roomRepository.findAll(pageable);

        RoomsResponseDto roomsResponseDto = new RoomsResponseDto();
        roomsResponseDto.setPageNumber(roomPage.getPageable().getPageNumber());
        roomsResponseDto.setTotalPages(roomPage.getTotalPages());
        roomsResponseDto.setRoomsDtoList(roomPage.stream().map(Room::getRoomDto).collect(Collectors.toList()));

        return roomsResponseDto;


    }



}
