package com.CarSelling.project.tools;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.CarSelling.project.entity.FavorisEntity;

public class Utility {
    @Autowired
    private Converter<String, ObjectId> stringToObjectIdConverter;

    public List<ObjectId> getIdAnnoncesFromFAV(List<FavorisEntity> favs) {
        List<ObjectId> array_Ids = new ArrayList<>();

        for (FavorisEntity f : favs) {
            array_Ids.add(new ObjectId(f.getIdannonce()));

        }
        return array_Ids;
    }
}
