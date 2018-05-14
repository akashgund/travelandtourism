(function () {
    angular
        .module("TourismApp")
        .controller("RegisterController", RegisterController);

    function RegisterController($http, $scope) {
        var vm = this;
        var localpath = "http://localhost:8080/";
        var url = "/api/";
        //vm.registerUserInDb = registerUserInDb;

        function registerUserInDb(firstName,lastName,password,email,password_confirmation)
        {
            var newUser;

            newUser ={
                "firstName":firstName,
                "lastName":lastName,
                "password":password,
                "email":email,
                "password_Confirmation":password_confirmation
            };
            var redirectToURL ="";
            $http
                .post(localpath+url+"registration", newUser)
                .then(function (response) {
                    $scope.user = response.data;
                    alert("Successfully registered!");
                    window.location = redirectToURL;
                }, function(error){
                    alert("Please try registering again ,Attempt Unsuccessful!");
                });
        }
        }
    }