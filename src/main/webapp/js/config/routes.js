/**
 * Created by yozmo on 3/4/14.
 */

betsApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
        when('/register', {
            templateUrl: 'views/signup.html',
            controller: 'SignUpCtrl'
        }).
        when('/profile/:id', {
            templateUrl: 'views/profile.html',
            controller: 'ProfileCtrl'
        }).
        otherwise({
            redirectTo: '/error'
        });
}]);