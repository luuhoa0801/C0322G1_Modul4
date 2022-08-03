package com.codegym.casestudy.repository.facility;

import com.codegym.casestudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(value = "select * from facility where `name` like :name and status = 0", nativeQuery = true)
    Page<Facility> findAllFacility(@Param("name") String name, Pageable pageable);

    @Modifying
    @Query(value = "update facility set status = 1 where id = :id", nativeQuery = true)
    void delete(@Param("id") int id);

    @Modifying
    @Query(value = "insert into facility (area,cost,description_other_convenience,facility_free,max_people," +
            "`name`,number_of_floors,pool_area,standard_room,`status`,facility_type_id,rent_type_id) " +
            "values (:area,:cost,:descriptionOtherConvenience,:facilityFree,:maxPeople,:name," +
            ":numberOfFloors,:poolArea,:standardRoom,:facilityType,:rentType)", nativeQuery = true)
    void create(@Param("area") int area,
                @Param("cost") double cost,
                @Param("descriptionOtherConvenience") String descriptionOtherConvenience,
                @Param("facilityFree") String facilityFree,
                @Param("maxPeople") int maxPeople,
                @Param("name") String name,
                @Param("numberOfFloors") int numberOfFloors,
                @Param("poolArea") Double poolArea,
                @Param("standardRoom") String standardRoom,
                @Param("facilityType") Integer facilityType,
                @Param("rentType") Integer rentType);


}
