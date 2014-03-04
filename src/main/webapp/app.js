/**
 * Created by yozmo on 3/1/14.
 */
'use strict'

var betsApp = angular.module('betsApp', ['ngResource', 'ngRoute']);

var restProvider = 'http://localhost:8080';
var accountSaltLength = 10;