package com.codeHotelSoft.HotelSotfServer.services.admin.rooms;


import com.codeHotelSoft.HotelSotfServer.dto.RoomDto;
import com.codeHotelSoft.HotelSotfServer.dto.RoomsResponseDto;

public interface RoomsService {

    boolean postRoom(RoomDto roomDto);


    RoomsResponseDto getAllRooms(int pageNumber);
}
