  clockd1_={
			  "indicate": true,
			  "indicate_color": "#fff",
			  "dial1_color": "#fff",
			  "dial2_color": "#fff",
			  "dial3_color": "#fff",
			  "time_add": 1,
			  "time_24h": true,
			  "date_add":3,
			  "date_add_color": "#fff",
			 };
	 
	  var c = document.getElementById('clock1_');
	  cns1_ = c.getContext('2d');
		
	  clock_conti(200,cns1_,clockd1_);
	  clock_digital(200,cns2_,clockd2_);
	  clock_norm(200,cns3_,clockd3_);
	  clock_binary(200,cns4_,clockd4_);
	  clock_follow(200,cns5_,clockd5_);
	  clock_circles(200,cns6_,clockd6_);
	  clock_dots(200,cns7_,clockd7_);
	  clock_roulette(200,cns8_,clockd8_);
	  clock_num(200,cns9_,clockd9_);
	  clock_planets(200,cns10_,clockd10_);
	  clock_digitalran(200,cns11_,clockd11_);
	  clock_bars(200,cns12_,clockd12_);
	  clock_grow(200,cns13_,clockd13_);
	  clock_random(200,cns14_,clockd14_);
	  clock_reverse(200,cns15_,clockd15_);