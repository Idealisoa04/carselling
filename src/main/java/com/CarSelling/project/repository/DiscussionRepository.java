package com.CarSelling.project.repository;

import java.util.List;

import com.CarSelling.project.entity.DiscussionEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscussionRepository extends JpaRepository<DiscussionEntity, Integer> {
    @Query(value="SELECT * from Discussion  where iduser1=:iduser1 and iduser2=:iduser2",nativeQuery = true)
    public DiscussionEntity findOneDiscussion(@Param("iduser1") Integer id, @Param("iduser2") Integer etat);
    
    @Query(value="SELECT * from Discussion  where iduser1=:iduser or iduser2=:iduser",nativeQuery = true)
    public List<DiscussionEntity> findAllDiscussion(@Param("iduser") Integer id);

    @Query(value="INSERT INTO Discussion (iduser1,iduser2) values (:iduser1,:iduser2)",nativeQuery = true)
    public void insertDiscussion(@Param("iduser1") Integer iduser1,@Param("iduser2") Integer iduser2);
    
}
