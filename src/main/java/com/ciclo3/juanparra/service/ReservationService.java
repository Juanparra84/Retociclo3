package com.ciclo3.juanparra.service;

import java.util.List;
import java.util.Optional;
import com.ciclo3.juanparra.model.Reservation;
import com.ciclo3.juanparra.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int reservationId) {
        return reservationRepository.getReservation(reservationId);
    }

    public Reservation save(Reservation rsv) {
        if (rsv.getIdReservation() == null) {
            return reservationRepository.save(rsv);
        } else {
            Optional<Reservation> consulta = reservationRepository.getReservation(rsv.getIdReservation());
            if (consulta.isEmpty()) {
                return reservationRepository.save(rsv);
            } else {
                return rsv;

            }
        }
    }

}
