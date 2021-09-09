import java.util.List;

public class Main {

    public static void main(String[] args) {

//Метод для добавления новой записи в таблицу;
//        users user1 = new users("fantastic2020", 22);
//        users user2 = new users("monarchMech", 10);
//        users user3 = new users("Mistik_twistik", 34);
//        users user4 = new users("Ramzes1998", 25);
//        users user5 = new users("gendalf_Grey", 17);
//        users user6 = new users("grandAuto_Driver", 19);
//        users user7 = new users("HarryPotniy", 19);
//        users user8 = new users("Gena_Shtopr", 27);
//        usersService.add(user1);
//        usersService.add(user2);
//        usersService.add(user3);
//        usersService.add(user4);
//        usersService.add(user5);
//        usersService.add(user6);
//        usersService.add(user7);
//        usersService.add(user8);

//Метод для редактиирования записи
//        users user9 = new users("Gena_Shtopr", 28);
//            usersService.edit(8,user9);

// Метод для нахождения пользователя по его имени «username»;
//        users users10 = usersService.find_by_username("Mistik_twistik");
//       System.out.println("Name: " + users10.getUsername());
//Метод для поиска всех записей, где возраст в диапазоне от 10 (включительно) до 35 (не включительно);
//            List<users> user = usersService.get_by_age_diapasons(10,35);
//            for(users us: user)
//                System.out.println("name " + us.getUsername() + ", and age " + us.getAge() );

//Метод для удаления по имени пользователя.
        usersService.delete_by_username("Ramzes1998");




    }
}
