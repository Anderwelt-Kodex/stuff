<?php
declare(strict_types=1);

function fizzbuzz(int $number) {
$three = 3;
$five = 5;
$fizz = 'fizz';
$buzz = 'buzz';

if(($number % $three) == 0 && ($number % $five) == 0){ 
$returnResult = $fizz.$buzz;
} else if (($number % $three) == 0){
$returnResult = $fizz;
} else if (($number % $five) == 0){
$returnResult = $buzz;
} else {
$returnResult = $number;
}

return $returnResult;

}