# Parking Lot

Requirements

- User can park cars on nearest available spot or spot they want.
- User can un-park their car only.
- User can check parking history of a spot 
- User can fetch where and when car was last parked.
- User can see available parking slots.


<hr/>

Actors:
- User
- Parking System (system)

Entites:
- Car (data object)
  - It holds details of the car
- Parking lot
  - It can park a car on available or provided slot
  - it can un-park
  - it can fetch available slots
- Slot
  - it can tell what car it holds
  - it can park/un-park car on it.
- ParkingHistory
  - it can fetch car/slot history
  - it can tell where it is parked or was parked last time.
- ParkingTime (data object)
  - time
  - date
  - enum Movement (PARK, UN_PARKED)

