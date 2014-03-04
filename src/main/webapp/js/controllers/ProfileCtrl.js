/**
 * Created by yozmo on 3/2/14.
 */

betsApp.controller('ProfileCtrl', ['$scope', 'AccountService', '$routeParams',
    function($scope, accountService, $routeParams) {

    $scope.userAccount = accountService.get({'id': $routeParams.id});

    alert("here");

}]);