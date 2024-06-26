package c322spring2024homework2.work.repository;

import c322spring2024homework2.work.model.Guitar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends CrudRepository<Guitar, String> {
    Guitar save (Guitar guitar);
    Guitar findBySerialNumber(String serialNumber);
    @Query("SELECT g FROM Guitar g WHERE " +
            "(:serialNumber IS NULL OR g.serialNumber = :serialNumber) AND " +
            "(:price IS NULL OR g.price = :price) AND " +
            "(:builder IS NULL OR g.builder = :builder) AND " +
            "(:model IS NULL OR g.model = :model) AND " +
            "(:guitarType IS NULL OR g.type = :guitarType) AND " +
            "(:backWood IS NULL OR g.backWood = :backWood) AND " +
            "(:topWood IS NULL OR g.topWood = :topWood)")
    List<Guitar> search(@Param("serialNumber") String serialNumber,
                        @Param("price") Double price,
                        @Param("builder") String builder,
                        @Param("model") String model,
                        @Param("guitarType") String guitarType,
                        @Param("backWood") String backWood,
                        @Param("topWood") String topWood);
}
