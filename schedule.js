class Room {
    constructor (roomNum, cap, isReserved, ownedBy) {
        this.roomNum = roomNum;
        this.capacity = cap;
        this.reserved = isReserved;
        this.ownedBy = ownedBy;
    }
}
class User {
    constructor (username, password, access) {
        this.username = username;
        this.password = password;
        this.access = access;
    }
    menu(instructions) {
        console.log(instructions);
        return 0;//Get input
    }
    run(choice, rooms) {
        //Do Something
    }
}
class Admin extends User{
    constructor(username, password) {
        super(username, password, 2);
    }
    menu() {
        super.menu("\nAccount contains  entries.\nPassword Manager Menu\n---------------------\n1) See rooms\n2) Add a new room\n3) Edit a room\'s availability\n4) Remove a room\n0) Save & Quit\n");
    }
    run(choice, rooms) {
        switch ((choice)) {
            case 1:
                rooms.printRooms();
                break;
            case 2:
                console.info("Which room would you like to add? ");
                var roomNumber = 1;
                console.info("How many people can it fit? ");
                var capacity = 1;
                rooms.add(new Room(("Library " + roomNumber), roomNumber, capacity, false, ""));
                break;
            case 3:
                console.info("Which room reservation would you like to change?");
                roomNumber = 1;
                console.info("Who is the reservation for? (Type * to make the room available again): ");
                var owner = "";
                if ((function (o1, o2) { if (o1 && o1.equals) {
                    return o1.equals(o2);
                }
                else {
                    return o1 === o2;
                } })(owner, "*")) {
                    rooms.changeReservation(roomNumber, "", false);
                    console.info("Room " + roomNumber + " has been made available.");
                }
                else {
                    rooms.changeReservation(roomNumber, owner, true);
                    console.info("Room " + roomNumber + " has been reserved for " + owner + ".");
                }
                break;
            case 4:
                console.info("Which room would you like to remove?");
                roomNumber = 1;
                if (rooms.remove(roomNumber))
                    console.info("Room " + roomNumber + " has been removed.");
                else
                    console.info("ERROR: Room " + roomNumber + " does not exist.");
                break;
            case 0:
                console.info("Goodbye!");
                return false;
            default:
                console.info("Invalid Input.");
        }
        return true;
    }
}
class Student extends User {
    constructor(username, password, access) {
        super(username, password, 1);
    }
    menu() {
        super.menu("Password Manager Menu\n---------------------\n1) See rooms\n2) Reserve a room\n3) Cancel a reservation\n0) Save & Quit\n");
    }
    run(choice, rooms) {
        switch ((choice)) {
            case 1:
                rooms.printRooms();
                break;
            case 2:
                console.info("Which room would you like to reserve?");
                var roomNumber = 0;
                while ((true)) {
                    {
                        try {
                            roomNumber = 1;
                        }
                        catch (e) {
                            console.info("Please enter an integer: ");
                        }
                        ;
                        if (rooms.validRoomNumber(roomNumber))
                            break;
                        console.info("Room does not exist, enter a valid room number: ");
                    }
                }
                ;
                if (rooms.reserve(roomNumber, this.getUsername()))
                    console.info("Room has been reserved.");
                else
                    console.info("ERROR: Room is already reserved.");
                break;
            case 3:
                console.info("Which reservation would you like to cancel?");
                roomNumber = 0;
                while ((true)) {
                    {
                        try {
                            roomNumber = 1;
                        }
                        catch (e) {
                            console.info("Please enter an integer: ");
                        }
                        ;
                        if (rooms.validRoomNumber(roomNumber))
                            break;
                        console.info("Room does not exist, enter a valid room number: ");
                    }
                }
                ;
                if (rooms.cancel(roomNumber, this.getUsername()))
                    console.info("Reservation has been cancelled.");
                else
                    console.info("ERROR: Room is not reserved by you.");
                break;
            case 0:
                console.info("Goodbye!");
                return false;
            default:
                console.info("Invalid Input.");
        }
        return true;
    }
}
class UserList { 
    constructor () {
        this.users = new Array();
        this.count = 0;
    }

    add(user) {
        this.users[this.count++] = user;
    }
    
    Login(userIn, passIn)
    {
        for(let i = 0; i < this.count; i++)
        {
            if(this.users[i].username == userIn)
            {
                if(this.users[i].password == passIn)
                {
                    return user;
                }
            }
        }
        return null;
    }
}

var listOfUsers = new UserList();
var rooms = new Array(new Room(205, 30, false, ""), new Room(204, 30, true, "student1"));
var access = 3;
var progLoop = true;
var user;
listOfUsers.add(new Student("student1", "pass"));
listOfUsers.add(new Student("student2", "pass"));
listOfUsers.add(new Admin("admin", "pass"));

document.getElementById("Login").addEventListener("click", function(){
    let userIn = document.getElementById("User").value;
    let passIn = document.getElementById("Pass").value;
    user = listOfUsers.Login(userIn, passIn);
    if (user === null) {
        document.getElementById("Message").innerText = "Wrong login";
    } else {
        document.getElementById("Message").innerText = "Success";
    }
})
/*
while (progLoop) {
    var choice = user.menu();
    progLoop = user.doSomething(choice, rooms);
}*/