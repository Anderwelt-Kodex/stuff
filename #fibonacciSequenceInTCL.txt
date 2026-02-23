#fibonacci sequence example in TCL
# variables to start
set x 0
set y 0
set loop 0
set fibonaList ""


# print the first 13 values of the fibonacci sequence
while {$loop <= 13} {

# output number
puts "$y"

# add new number to end of list
lappend fibonaList "$y"

#calculate and set fibonacci numbers
if {$y == 0} {
incr y

} else {
set z $y
set y [expr $x + $y]
set x $z
}

# update loop variable +1
incr loop

}
# output complete list of fibonacci numbers from loop
puts "$fibonaList"