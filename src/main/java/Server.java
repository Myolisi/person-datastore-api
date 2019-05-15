import com.fasterxml.jackson.databind.ObjectMapper;
import dao.PersonDao;
import mapper.PersonInforMapper;
import model.*;
import org.jdbi.v3.core.Handle;
import org.omg.CORBA.DATA_CONVERSION;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static spark.Spark.*;

class Server {

    public static void main(String[] args) {

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        path("/person", () -> {
            get("/:search", "application/json", (request, response) -> {
                String search = request.params(":search");
                String searchToUpper = search.substring(0, 1).toUpperCase() + search.substring(1);
                return PersonService.findPerson(searchToUpper);
            }, new JacksonTransformer());
        });

        //Search person
        get("/person/:search", "application/json", (request, response) -> {
            String search = request.params(":search");
            String searchToUpper = search.substring(0, 1).toUpperCase() + search.substring(1);
            return PersonService.findPerson(searchToUpper);
        }, new JacksonTransformer());

        //search by ID
        get("/personInformation/:search", "application/json", (request, response) -> {
            return PersonService.findById(request.params(":search"));
        }, new JacksonTransformer());

        //search country
        get("/country/:search", "application/json", (request, response) -> {
            return PersonService.findCountry(request.params(":search"));
        }, new JacksonTransformer());
                /*
         * update
         *
         * */

        // update person
        put("/person/:id", "application/json", (request, response) -> {
            Person person = new ObjectMapper().readValue(request.body(), Person.class);
            int id = Integer.valueOf(request.params(":id"));
            PersonService.updatePerson(person, id);
            return "Success";
        });

        // update telephone
        put("/telephone/:id", "application/json", (request, response) -> {
            Telephone telephone = new ObjectMapper().readValue(request.body(), Telephone.class);
            int id = Integer.valueOf(request.params(":id"));
            PersonService.updateTelephone(telephone, id);
            return "Success";
        });

        // update person telephone
        put("/personTelephone/:id", "application/json", (request, response) -> {
            PersonTelephone personTelephone = new ObjectMapper().readValue(request.body(), PersonTelephone.class);
            int id = Integer.valueOf(request.params(":id"));
            PersonService.updatePersonTelephone(personTelephone, id);
            return "Success";
        });

        // update address
        put("/address/:id", "application/json", (request, response) -> {
            Address address = new ObjectMapper().readValue(request.body(), Address.class);
            int id = Integer.valueOf(request.params(":id"));
            PersonService.updateAddress(address, id);
            return "Success";
        });

        // update person address
        put("/personAddress/:id", "application/json", (request, response) -> {
            PersonAddress address = new ObjectMapper().readValue(request.body(), PersonAddress.class);
            int id = Integer.valueOf(request.params(":id"));
            PersonService.updatePersonAddress(address, id);
            return "Success";
        });

        // update country
        put("/country/:id", "application/json", (request, response) -> {
            Country country = new ObjectMapper().readValue(request.body(), Country.class);
            int id = Integer.valueOf(request.params(":id"));
            PersonService.updateCountry(country, id);
            return "Success";
        });

        /*
         * add
         *
         * */

        //add person
        post("/person", "application/json", (request, response) -> {
            Person person = new ObjectMapper().readValue(request.body(), Person.class);
            PersonService.addPerson(person);
            return "Success";
        });

        //Person telephone
        post("/personTelephone", "application/json", (request, response) -> {
            PersonTelephone telephone = new ObjectMapper().readValue(request.body(), PersonTelephone.class);
            PersonService.addPersonTelephone(telephone);
            return "Success";
        });

        //add telephone
        post("/telephone", "application/json", (request, response) -> {
            Telephone telephone = new ObjectMapper().readValue(request.body(), Telephone.class);
            PersonService.addTelephone(telephone);
            return "Success";
        });

        //add address
        post("/address", "application/json", (request, response) -> {
            Address address = new ObjectMapper().readValue(request.body(), Address.class);
            PersonService.addAddress(address);
            return "Success";
        });

        //add person address
        post("/personAddress", "application/json", (request, response) -> {
            PersonAddress address = new ObjectMapper().readValue(request.body(), PersonAddress.class);
            PersonService.addPersonAddress(address);
            return "Success";
        });

        //add country
        post("/country", "application/json", (request, response) -> {
            Country country = new ObjectMapper().readValue(request.body(), Country.class);
            PersonService.addCountry(country);
            return "Success";
        });

        /*
         *   get
         *
         */
        //GET all
        //GET persons




        get("/getAddresses/:user", "application/json", (request, response) -> {
            int id = Integer.valueOf(request.params(":user"));
            return PersonService.getAddresses(id);
        }, new JacksonTransformer());

        get("/getTelephones/:user", "application/json", (request, response) -> {
            int id = Integer.valueOf(request.params(":user"));
            return PersonService.getTelephones(id);
        }, new JacksonTransformer());

        //GET persons
        get("/persons", "application/json", (request, response) ->
                        PersonService.getAllPersons()
                , new JacksonTransformer());

        //Get Telephones
//        get("/telephones", "application/json", (request, response) ->
//                        PersonService.getTelephone()
//                , new JacksonTransformer());

        //Get Person Telephones
        get("/personTelephones", "application/json", (request, response) ->
                        PersonService.getPersonTelephone()
                , new JacksonTransformer());


        //Get Person Country
        get("/personCountry/:search", "application/json", (request, response) -> {
            int id = Integer.valueOf(request.params(":search"));
            return PersonService.getPersonCountry(id);
        }, new JacksonTransformer());

        //Get person telphone
        get("/personTelephone", "application/json", (request, response) ->
                        PersonService.getPerTelephone()
                , new JacksonTransformer());

        //Get person telphone
        get("/personAddress", "application/json", (request, response) ->
                        PersonService.getPerAddress()
                , new JacksonTransformer());


        //Get addresses
//        get("/addresses", "application/json", (request, response) ->
//                        PersonService.getAddress()
//                , new JacksonTransformer());

        //Get Person addresses
        get("/personAddresses", "application/json", (request, response) ->
                        PersonService.getPersonAddress()
                , new JacksonTransformer());

        //Get country
        get("/countries", "application/json", (request, response) ->
                        PersonService.getCountry()
                , new JacksonTransformer());

        //page not found error
        notFound((request, response) ->
                "<html><body><h1 style='color:red'>Page not found, please check your url</h1></body></html>"
        );

        get("/inform", "application/json", (request, response) ->{

            List<Telephone> number = new ArrayList<>();
            Person p = PersonService.getPerson();
            try {
                    for (Telephone telephone : PersonService.getTelephones(p.getId())) {
                        number.add(telephone);
                    }
                } catch (DaoException e) {
                    e.printStackTrace();
                }

                p.setTelephones(number);
            return p;
        }, new JacksonTransformer());




//        List<Telephone> number = new ArrayList<>();
//        for (Person arg : PersonService.getPerson()) {
//            try {
//                for (Telephone telephone : PersonService.getTelephones(arg.getId())) {
//                    number.add(telephone);
//                }
//            } catch (DaoException e) {
//                e.printStackTrace();
//            }
//        }
//        Person p = new Person();
//        p.setTelephones(number);



    }
}

