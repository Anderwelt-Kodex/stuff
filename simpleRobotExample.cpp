#ifndef ROBOT_SIMULATOR_H
#define ROBOT_SIMULATOR_H

#include <stdbool.h>
#include <string.h>
#include <iostream>


enum BEARING {
    NORTH = 0,
    EAST = 1,
    SOUTH = 2,
    WEST = 3
};

struct Position {
    int x;
    int y;
};

struct Robot {
    struct Position position;
    enum BEARING bearing;
};

struct Position get_position(struct Robot robot) {

if(!robot.position.y || !robot.position.x || !robot.bearing){
int nx = 0;
int ny = 0;
int nb = 0;

} else{
int nx = robot.position.x;
int ny = robot.position.y;
int nb = robot.bearing;

 std::cout << nx;
    std::cout << ny;
    std::cout << nb;
}
   int nx = robot.position.x;
int ny = robot.position.y;
int nb = robot.bearing;


 std::cout << nx<< "\n";
    std::cout << ny<< "\n";
    std::cout << nb<< "\n";

std::cout << "x: " << nx << ", y: " << ny<< "\n";
return Position{nx, ny};
}

enum BEARING get_bearing(struct Robot robot) {

int actBearing = robot.bearing;

return (BEARING)actBearing;
}

void turn_right(struct Robot *robot) {
    int rightBearing = robot->bearing;
  
std::cout << rightBearing<< "right\n"; //0right
    if(rightBearing < 3){
    rightBearing = rightBearing +1;
    }else if(rightBearing == 3){
        //before
        rightBearing =  0;
    }else{
       //Error
    }

robot->bearing = static_cast<BEARING>(rightBearing);

return;

}

void turn_left(struct Robot *robot) {

int leftBearing =  robot->bearing;
  std::cout << leftBearing<< "left\n";
    if(leftBearing > 0 && leftBearing < 4){
    leftBearing = leftBearing -1;
    }else if(leftBearing == 0){
    //before
        leftBearing =  3;
    }else{
       //Error
    }
    robot->bearing = static_cast<BEARING>(leftBearing);

    return;
}

void advance(struct Robot *robot) {
int nx = robot->position.x;
int ny = robot->position.y;
int nb = robot->bearing;

if(nb == 0){
ny = ny+1;
}else if(nb == 1){
nx = nx+1;
}else if(nb == 2){
ny = ny-1;
}else if(nb == 3){
nx = nx-1;
}else{
//Error
}
robot->position.x = nx;
robot->position.y = ny;

return ;
}

void execute_sequence(struct Robot *robot, char *sequence) {
    
        for (int n = 0; sequence[n] != '\0'; n++) {
        char x = sequence[n];

        if (x == 'R') {
            turn_right(robot);
        } else if (x == 'L') {
            turn_left(robot);
        } else if (x == 'A') {
            advance(robot);
        } else {
            // error handling
        }
    }
    return;
}
#endif