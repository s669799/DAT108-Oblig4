package no.hvl.dat108.DAT108.Oblig4.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import no.hvl.dat108.DAT108.Oblig4.entity.Deltager;

public interface DeltagerRepo extends JpaRepository<Deltager, Integer> {
}