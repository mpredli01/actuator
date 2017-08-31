package org.redlich.actuator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.endpoint.Endpoint;
import org.springframework.boot.endpoint.ReadOperation;
import org.springframework.boot.endpoint.Selector;
import org.springframework.boot.endpoint.WriteOperation;
import org.springframework.stereotype.Component;

@Endpoint(id = "person")
@Component
public class PersonEndpoint {

    private final Map<String, Person> people = new ConcurrentHashMap<>();

    PersonEndpoint() {
        this.people.put("mike", new Person("Michael Redlich"));
        this.people.put("rowena", new Person("Rowena Redlich"));
        this.people.put("barry", new Person("Barry Burd"));
    }

    @ReadOperation
    public List<Person> getAll() {
        return new ArrayList<>(this.people.values());
    }

    @ReadOperation
    public Person getPerson(@Selector String person) {
        return this.people.get(person);
    }

    @WriteOperation
    public void addOrUpdatePerson(@Selector String name, String person) {
        this.people.put(name, new Person(person));
    }

    public static class Person {
        private String name;

        Person(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }
}
