/**
 * Created by yozmo on 3/1/14.
 */

betsApp.factory('AccountService',function ($resource) {
    return $resource(restProvider + '/account/:action/', {}, {
        list: { method: 'GET', params:{action: 'all'}, isArray: true},
        create: {method: 'POST', params:{action: 'new'}},
        get: {method: 'GET', params: {action: 'get', id: '@id'}}
    });
    })
;
