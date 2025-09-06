package com.codeHotelSoft.HotelSotfServer.repository;


import com.codeHotelSoft.HotelSotfServer.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository  extends JpaRepository<Room,Long> {







}
