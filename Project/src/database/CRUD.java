package database;

public interface Crud<T>{
    // T mag je invullen bij het implementeren van een class die Crud gaat gebruiken.
    // Bijvoorbeeld: implements Crud<Person> voor de Person class 😎
    public void create(T params);

    // specifiek 1 entiteit terug
    public T get(int id);
    // overflow 🌊 methode om alles terug te krijgen 
    public T get();

    public void update(int id,T params);

    public void delete(int id);
}
