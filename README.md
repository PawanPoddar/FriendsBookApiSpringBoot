# FriendsBookApiSpringBoot
#Requirment:
##Eclipse,STS
##Spring Boot Framwork
##MYSQL database

#In this project Binary Search Tree Algorith is used to finding to the Kth position friends/users;

# A user should be able to create his profile. 
localhost:8081/user/register
{
	"name": "Shyam",
            "age": 20,
            "gender":"Male",
            "address":" kamal Vihar",
            "mobile": 8925465845,
            "email": "91234pawan",
            "password": "12345"
}


# A user should be able to view his friend list. 
localhost:8081/friend/user/allFriends/{user_id}

Output:{
    "status": 200,
    "errors": null,
    "data": [
        {
            "id": 30,
            "name": "Ram",
            "age": 26,
            "gender": "male",
            "address": "ram nagar",
            "mobile": 548798575,
            "email": "abc@gmail.com",
            "password": "acn13"
        }
    ]
},
{
    "status": 200,
    "errors": null,
    "data": [
        {
            "id": 34,
            "name": "Shyam",
            "age": 26,
            "gender": "male",
            "address": "Mohan Nagar",
            "mobile": 548798575,
            "email": "abc@gmail.com",
            "password": "acn13"
        }
    ]
}

# Given an input integer K, a user should be able to view all connections at distance K 
from him

localhost:8081/friend/near/{K input distance}


# A user should be able to add another user in his friend list. Friend list is mutual i.e if A 
is friend of B, then B is also friend of A.
http://localhost:8081/friend/makeFriend

{
    "fId": 31,
    "id": 21,
    "user":{
            "id": 34,
            "name": "Shyam",
            "age": 20,
            "gender": "Male",
            "address": " kamal Vihar",
            "mobile": 8925465845,
            "email": "91234pawan",
            "password": "12345"
    }
}

 # A user should be able to remove another user from his friend list. 
localhost:8081/friend/deleteFriend/{friend_id}

# All Users List:
localhost:8081/user/allUsers

# Delete Specific User
localhost:8081/user/delete/{user_id}


