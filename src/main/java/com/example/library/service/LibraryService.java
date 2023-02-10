package com.example.library.service;

import com.example.library.model.Library;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LibraryService {
    private static List<Library> libraries=new ArrayList<>();
    private static int libraryCount=0;

    static {
        libraries.add(new Library(++libraryCount,"R K Library ", "Muradnagar", 986590, "Reading Rooms,AC Rooms"));
        libraries.add(new Library(++libraryCount,"A T Library ", "Modinagar", 45897, "AC Rooms & Reading Rooms"));
        libraries.add(new Library(++libraryCount,"P T Library", "Ghaziabad", 98345, "AC Rooms & Cabin"));
    }

    public List<Library> findAll() {
        return libraries;
    }

    public Library findById(int id) {
        for (Library library : libraries) {
            if (library.getId() == id) {
                return library;
            }
        }
        return null;
    }
    public Library findByName(String name) {
        for (Library library : libraries) {
            if (library.getLibraryName().equals(name)) {
                return library;
            }
        }
        return null;
    }

    public Library addLibrary(Library library) {
        if (library.getId() == 0) {
            library.setId(++libraryCount);
        }
        libraries.add(library);
        return library;
    }

    public Library updateLibrary(int id, Library library) {
        int index = -1;
        for (int i = 0; i < libraries.size(); i++) {
            if (libraries.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return null;
        }
        library.setId(id);
        libraries.set(index, library);
        return library;
    }
    public Library updateLibraryByName(String name, Library library) {
        Library existingLibrary = findByName(name);
        if (existingLibrary == null) {
            return null;
        }
        int index = libraries.indexOf(existingLibrary);
        library.setId(existingLibrary.getId());
        libraries.set(index, library);
        return library;
    }


    public void deleteLibrary(int id) {
        Library library = findById(id);
        if (library != null) {
            libraries.remove(library);
        }
    }
    public void deleteLibraryByName(String name) {
        Library library = findByName(name);
        if (library != null) {
            libraries.remove(library);
        }
    }
}