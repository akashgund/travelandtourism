(function () {
    angular
        .module("TourismApp")
        .controller("LoginController", LoginController);

    function LoginController($http, $scope) {
        var vm = this;
        var localpath = "http://localhost:8080/";
        var url = "/api/";
        vm.checkIfValidUser = checkIfValidUser;

        function checkIfValidUser(email, password) {

            $http
                .get(localpath+url+"?email="+email+"&password="+password)
                .then(function (response) {
                    $scope.user = response.data;
                    if (response.data.length === 0){
                        alert ("Incorrect Login, Please register first!");
                        console.log(response);
                    }
                    else
                    {
                        localStorage.setItem('email',email);
                        alert("Successfully logged in as " + username);
                        console.log(response);
                        localStorage.setItem("userType",userType);
                        if(localStorage.getItem("userType")==='admin') {
                            window.location.href = localpath+"#!/admin";
                            location.reload(true);
                        }
                        else {
                            window.location.href = localpath+"#!/mypage";
                            location.reload(true);
                        }
                    }

                }, function(){
                    alert("Please register first!");
                });

            console.log(username);
            console.log(password);
            console.log(userType);
        }
    }
})();
