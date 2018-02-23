/************************************************************************************
This file describes the environment setup and libraries used for the TMAN's algorithm

*************************************************************************************/
Environment -
1) OS - Linux

2) java version "1.7.0_80"
   Java(TM) SE Runtime Environment (build 1.7.0_80-b15)
   Java HotSpot(TM) 64-Bit Server VM (build 24.80-b11, mixed mode)

3) Software needed-
   jfreechart-1.0.1.jar
   jcommon-1.0.0.jar

4) Add the libraries into CLASSPATH
   $export CLASSPATH=$CLASSPATH:/Home/Documents/jfreechart-1.0.1.jar:/Home/Documents/jcommon-1.0.0.jar

5) Program Structure-

  a) networkInitialization() - 

The Network initialization phase. Every node randomly selects k neighbors and places them into its neighbor list. The nodes are placed at a location given by the overlay network topology.

  b) networkEvolution() - 

In every cycle of the iterative algorithm, every node randomly selects one of its neighbors, and then sends a list consisting of the identifiers of its neighbors and of itself to that neighbor. The selected neighbor also sends its neighbors list back to the node which initiated the action. Upon receiving the new neighbor list, the nodes select the nearest k nodes from both the new and old lists as their neighbors and discards all the others.

  c) updateNL() - 

Function to update the nodes neighbor list with the k nearest elements. The final nieghbor list consists of k nearest elements from its own neighbor list and the received neighbor list combined.

  d) distance() -

Description: Returns the distance between 2 nodes based on its x y coordinates. 
In 'B' topology For the Nth node, it returns a minimum distance for 1st and N-1th node and maximum distance for all other nodes.
Parameters: id1 - Node id
   	    id2 - Node id
Returns : Distance 

  e) Class Node

Containes the members - node_id, x_co, y_co, theta, neighbors[], received_list[].

6) File - XYLineChart_AWT

Program to plot the graph.
