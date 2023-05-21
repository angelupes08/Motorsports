The project contains entities Drivers and Teams.

Teams and Drivers have one to many relationship.

The project contains following endpoints.

@PostMapping("/drivers")	   - Posts drivers to DB
@GetMapping("/driver")       - Gets Driver details by Id
@GetMapping("/drivers")      - Gets Driver details
@PutMapping("/updatedriver") - Updates Driver details
@GetMapping("/nationality")  - Gets Driver details by Nationality
@GetMapping("/country")      - Gets Driver and Teams details by Nationality
@GetMapping("/teams")        - Gets Teams details
	
