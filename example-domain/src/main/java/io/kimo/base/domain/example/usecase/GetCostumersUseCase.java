package io.kimo.base.domain.example.usecase;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import io.kimo.base.domain.BaseUseCase;
import io.kimo.base.domain.Callback;
import io.kimo.base.domain.example.entity.CostumerEntity;
import io.kimo.lib.faker.Faker;

/**
 * Get Costumers use case
 *
 * This use case is supposed to return an array of CustomerEntities.
 *
 * To let the example more real I randomly generated scenarios that errors could occur.
 *
 * Scenario 1: Filled array - 45% of chance to happen
 * In this scenario the use case returns an array of CustomerEntity.
 * The presenter back in the presentation layer might do something to display the array.
 *
 * Scenario 2: Empty array - 30% of chance to happen
 * In this scenario the use case returns an empty array. The presenter back in the presentation
 * layer might check if the array is empty, displaying a proper view.
 *
 * Scenario 3: Error - 12% of chance to happen
 * In this scenario I simulated a non unexpected error. The use case throws an error that is handled
 * the onError callback of the BaseUseCase. The presenter might treat this error as well.
 */
public class GetCostumersUseCase extends BaseUseCase<List<CostumerEntity>> {

    public static final int FILLED_ARRAY = 0;
    public static final int EMPTY_ARRAY = 1;
    public static final int ERROR = 2;
    public static final int UNKNOWN = 3;

    public static final int SEED = 100;

    public static final int CHANCE_TO_RETURN_FILLED_ARRAY = 45;
    public static final int CHANCE_TO_RETURN_EMPTY_ARRAY = 30;
    public static final int CHANCE_TO_RETURN_AN_ERROR = 12;

    public static final String ERROR_MESSAGE = "An error message";

    private Context context;

    public GetCostumersUseCase(Context context, Callback<List<CostumerEntity>> callback) {
        super(callback);
        this.context = context;
    }

    @Override
    public List<CostumerEntity> perform() throws Exception {
        List<CostumerEntity> items = new ArrayList<>();

        // wait a little bit to let the progressbar appear
        Thread.sleep(1000);

        int scenarioToBeReturned = FILLED_ARRAY;

        if(scenarioToBeReturned == FILLED_ARRAY) {
            for(int i = 0; i < 100; i++) {
                items.add(new CostumerEntity(Faker.with(context).Name.fullName(), Faker.with(context).Name.title(), Faker.with(context).Url.image()));
            }

            return items;
        } else if(scenarioToBeReturned == EMPTY_ARRAY) {
            return items;
        } else {
            throw new Exception(ERROR_MESSAGE);
        }
    }

    private int randomScenario() {
        double chance = Math.random() * SEED;

        if( (chance -= CHANCE_TO_RETURN_EMPTY_ARRAY) < 0)
            return EMPTY_ARRAY;

        if( (chance -= CHANCE_TO_RETURN_AN_ERROR) < 0)
            return ERROR;

        if( (chance -= CHANCE_TO_RETURN_FILLED_ARRAY) < 0)
            return FILLED_ARRAY;

        return UNKNOWN;
    }
}
