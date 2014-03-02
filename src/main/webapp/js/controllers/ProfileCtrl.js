/**
 * Created by yozmo on 3/2/14.
 */

betsApp.controller('ProfileCtrl', ['$scope', 'AccountService', function($scope, accountService) {

    $scope.userAccount = {};

    $scope.showProfile = function (id) {

        $scope.userAccount = accountService.get({'id': id});

    }

}]);