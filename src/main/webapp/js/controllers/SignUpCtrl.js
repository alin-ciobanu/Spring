/**
 * Created by yozmo on 3/1/14.
 */
'use strict'

betsApp.controller('SignUpCtrl', ['$scope', 'AccountService', function($scope, accountService){

    $scope.user = {
        'username': '',
        'password': '',
        'email': ''
    };

    $scope.createNewUser = function () {

        var userAccount = {};

        userAccount.username = $scope.user.username;
        userAccount.email = $scope.user.email;
        userAccount.salt = $scope.getRandomString(accountSaltLength);
        var hash = CryptoJS.SHA256($scope.user.password + userAccount.salt);
        userAccount.passwordHash = hash.toString(CryptoJS.enc.Base64);
        userAccount.dateCreated = ""; // doesn't matter - server will change it to current date

        accountService.create(userAccount);

    };

    $scope.getRandomString = function(length){
        var s= '';
        var randomchar=function(){
            var n= Math.floor(Math.random()*62);
            if(n<10) return n; //1-10
            if(n<36) return String.fromCharCode(n+55); //A-Z
            return String.fromCharCode(n+61); //a-z
        }
        while(s.length < length) s+= randomchar()
        return s;
    }

}]);
