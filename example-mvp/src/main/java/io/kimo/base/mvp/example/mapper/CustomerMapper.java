package io.kimo.base.mvp.example.mapper;


import io.kimo.base.domain.BaseMapper;
import io.kimo.base.domain.example.entity.ExampleEntity;
import io.kimo.base.mvp.example.model.CustomerModel;

public class CustomerMapper extends BaseMapper<ExampleEntity, CustomerModel> {

    public static final String SEPARATOR = "@__I_AM_AN_AWESOME_SEPARATOR__@";

    @Override
    public CustomerModel toModel(ExampleEntity entity) {
        CustomerModel model = new CustomerModel();

        model.setName(entity.getName());
        model.setProfession(entity.getTitle());
        model.setBackgroundUrl(entity.getImageUrl());

        return model;
    }

    @Override
    public String serializeModel(CustomerModel model) {
        StringBuilder sb = new StringBuilder();

        sb.append(model.getName())
                .append(SEPARATOR)
                .append(model.getProfession())
                .append(SEPARATOR)
                .append(model.getBackgroundUrl());

        return sb.toString();
    }

    @Override
    public CustomerModel deserializeModel(String serializedModel) {
        CustomerModel model = new CustomerModel();

        String [] serializedFields = serializedModel.split(SEPARATOR);

        model.setName(serializedFields[0]);
        model.setProfession(serializedFields[1]);
        model.setBackgroundUrl(serializedFields[2]);

        return model;
    }
}
