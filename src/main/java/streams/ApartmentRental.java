package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApartmentRental {

    List<Apartment> apartments = new ArrayList<>();

    public void addApartment(Apartment newApartment) {
        apartments.add(newApartment);
    }

    public List<Apartment> findApartmentByLocation(String location) {
        return apartments.stream()
                .filter(apartment -> apartment.getLocation().equals(location))
                .toList();
    }

    public List<Apartment> findApartmentByExtras(String... location) {
        return apartments.stream()
                .filter(apartment -> apartment.getExtras().containsAll(Arrays.asList(location)))
                .toList();
    }

    public boolean isThereApartmentWithBathroomType(BathRoomType bathRoomType) {
        return apartments.stream()
                .anyMatch(apartment -> apartment.getBathRoomType().equals(bathRoomType));
    }

    public List<Integer> findApartmentsSize() {
        return apartments.stream()
                .map(apartment -> apartment.getSize())
                .distinct()
                .collect(Collectors.toList());
    }
}