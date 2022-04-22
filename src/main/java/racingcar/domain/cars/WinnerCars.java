package racingcar.domain.cars;

import racingcar.domain.car.Car;

import java.util.List;

public class WinnerCars {
    private final List<Car> carList;

    public WinnerCars(List<Car> carList) {
        this.carList = carList;
    }

    public int numberOfWinner() {
        return carList.size();
    }

    public Car getWinnerCar(int idx) {
        return carList.get(idx);
    }
}
