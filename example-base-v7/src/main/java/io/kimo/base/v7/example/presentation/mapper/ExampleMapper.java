package io.kimo.base.v7.example.presentation.mapper;


import io.kimo.base.domain.BaseMapper;
import io.kimo.base.v7.example.domain.entity.ExampleEntity;
import io.kimo.base.v7.example.presentation.mvp.model.ExampleModel;

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
