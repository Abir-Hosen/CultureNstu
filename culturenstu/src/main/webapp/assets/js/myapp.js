$(function(){

	switch(menu){
	case 'Home':
		$('#home').addClass('active');
		break;
	case 'Profile':
		$('#profile').addClass('active');
		break;
	}

	$('.dropdown').dropdown();

});
