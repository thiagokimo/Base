package io.kimo.base.v7.example.domain.usecase;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import io.kimo.base.domain.BaseUseCase;
import io.kimo.base.domain.Callback;
import io.kimo.base.v7.example.domain.entity.ExampleEntity;
import io.kimo.lib.faker.Faker;

public class ExampleUseCase extends BaseUseCase<List<ExampleEntity>> {

    private Context context;

    public ExampleUseCase(Context context, Callback<List<ExampleEntity>> callback) {
        super(callback);
        this.context = context;
    }

    @Override
    public List<ExampleEntity> perform() {
        List<ExampleEntity> items = new ArrayList<>();

        for(int i = 0; i < 100; i++) {
            items.add(new ExampleEntity(Faker.with(context).Name.firstName(), Faker.with(context).Number.positiveDigit()));
        }

        return items;
    }
}
