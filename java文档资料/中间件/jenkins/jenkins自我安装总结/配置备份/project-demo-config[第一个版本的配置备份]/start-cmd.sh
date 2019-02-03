#!/bin/bash
c=0;
echo "xxx$c"
while [ $c -lt 100 ]
do
 sleep 1
 if [ $c -eq 5 ];
 then
    break;
 fi
 echo "value c is $c"
 c=`expr $c + 1`
done
c=ddd
echo chengxu zhixin wancheng $c
