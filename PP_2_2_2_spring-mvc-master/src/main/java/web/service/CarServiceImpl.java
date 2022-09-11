package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService {
    public List<Car> carList;
    {
        carList = new ArrayList<>();

        carList.add(new Car("Ford", "Focus", "Yellow"));
        carList.add(new Car("Mazda", "3", "White"));
        carList.add(new Car("Volvo", "XZ", "Black"));
        carList.add(new Car("Nissan", "Almera", "Red"));
        carList.add(new Car("Citroen", "C3", "Green"));
    }
    @Override
    public List<Car> carList(int count) {
        if (count > carList.size() || count == 0) {
            return carList;
        }
        return carList.stream().limit(count).collect(Collectors.toList());
    }
}
