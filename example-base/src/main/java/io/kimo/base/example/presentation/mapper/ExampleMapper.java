package io.kimo.base.example.presentation.mapper;

import io.kimo.base.domain.BaseMapper;
import io.kimo.base.example.domain.entity.ExampleEntity;
import io.kimo.base.example.presentation.mvp.model.ExampleModel;

public class ExampleMapper extends BaseMapper<ExampleEntity, ExampleModel> {
    @Override
    public ExampleModel toModel(ExampleEntity entity) {
        ExampleModel model = new ExampleModel();

        model.setName(entity.getName());

        return model;
    }

    @Override
    public String serializeModel(ExampleModel model) {
        // serialize your model here
        return null;
    }

    @Override
    public ExampleModel deserializeModel(String serializedModel) {
        // deserialize your model here
        return null;
    }
}
