package io.kimo.base.example.mapper;

import io.kimo.base.domain.BaseMapper;
import io.kimo.base.domain.example.entity.ExampleEntity;
import io.kimo.base.example.mvp.model.ExampleModel;

public class ExampleMapper extends BaseMapper<ExampleEntity, ExampleModel> {

    public static final String SEPARATOR = "@__I_AM_AN_AWESOME_SEPARATOR__@";

    @Override
    public ExampleModel toModel(ExampleEntity entity) {
        ExampleModel model = new ExampleModel();

        model.setName(entity.getName());
        model.setProfession(entity.getTitle());
        model.setBackgroundUrl(entity.getImageUrl());

        return model;
    }

    @Override
    public String serializeModel(ExampleModel model) {
        StringBuilder sb = new StringBuilder();

        sb.append(model.getName())
                .append(SEPARATOR)
                .append(model.getProfession())
                .append(SEPARATOR)
                .append(model.getBackgroundUrl());

        return sb.toString();
    }

    @Override
    public ExampleModel deserializeModel(String serializedModel) {
        ExampleModel model = new ExampleModel();

        String [] serializedFields = serializedModel.split(SEPARATOR);

        model.setName(serializedFields[0]);
        model.setProfession(serializedFields[1]);
        model.setBackgroundUrl(serializedFields[2]);

        return model;
    }
}
