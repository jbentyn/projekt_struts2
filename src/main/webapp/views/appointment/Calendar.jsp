<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../Tags.jsp"%>

<html>
<head>
<link rel="stylesheet" href="js/fullcalendar-2.2.3/fullcalendar.css" type="text/css">
<script src="js/moment/moment-with-locales.min.js"></script>
<script src="js/fullcalendar-2.2.3/fullcalendar.min.js"></script>


<script>
function showMessageDialog(header, message){
	 $( "#dialog" ).html(message);
	
	 $( "#dialog" ).dialog({
         resizable: false,
         height:200,
         width:500,
         modal: true,
         title: header,
         buttons: {
                    OK: function() {
                        $("#dialog").dialog( "close" );
                    },
                    
                  }
    });
}

function refetchAppointments(){
	$('#calendar').fullCalendar( 'refetchEvents' );
}


	$(document).ready(function() {

		$('#calendar').fullCalendar({

			editable : false,
			allDaySlot: false,
			selectable : false,
			selectHelper : false,
			eventDurationEditable :false,
			eventOverlap:false,
			theme : true,
			weekends:false,
			forceEventDuration:true,
			defaultTimedEventDuration:'00:30:00',
			firstDay : 1,
			defaultView : 'agendaWeek',
			bussinesHours : {
				start : '9:00',
				end : '17:00'
			},
			slotDuration : "0:30:00",
			minTime : "9:00:00",
			maxTime : "17:00:00",
			timeFormat : {
				agenda : 'H:mm',
				'' : 'H:mm'
			},
			header :{
			    left:   '',
			    center: '',
			    right:  'today prev,next'
			},
			height : 550,
	
		    events: function(start, end, timezone, callback) {
		    	var id = document.getElementById('doctor-select').value *1;
		    	
		        $.ajax({
		            url: 'loadAppointment.action',
		            dataType: 'json',
		            data: {
		                start: start.format("YYYY-MM-DD"),
		                end: end.format("YYYY-MM-DD"),
		                doctorId :id
		            },
		            success: function(data) {
		                console.log(data);
		                callback(data);
		            },
		            error : function(e) {
		            	 alert(JSON.stringify(e));
						showMessageDialog("Error",'there was an error while fetching appointments!');
					}
		        });
		    },
		    
		    dayClick: function(start, allDay, jsEvent, view) {
		    
		    	if (!moment(start).isAfter()  ){
		    		showMessageDialog("Error","You can't get appointment for past date");
		    	}
		    	else{
		    	
			    	var doctor = document.getElementById('doctor-select').selectedOptions[0].innerHTML;
					var message = "Confirm appointment with doctor<br> "+doctor+" <br>at " +start.format("YYYY-MM-DD  HH:mm");
			    	 $( "#dialog" ).html(message);
			    	 $( "#dialog" ).dialog({
			             resizable: false,
			             height:200,
			             width:500,
			             modal: true,
			             title: "Confirm appointment",
			             buttons: {
			                        OK: function() {
			                        	var id = document.getElementById('doctor-select').value *1;
			           		    	 
			            				$.ajax({
			            			            url: 'createAppointment.action',
			            			            dataType: 'json',
			            			            data: {
			            			                start: start.format("YYYY-MM-DD  HH:mm:ss"),
			            			                doctorId :id
			            			            },
			            			            success: function(data) {
			            			            	refetchAppointments();
			            			            	$("#dialog").dialog( "close" );
			            			            },
			            			            error : function(e) {
			            			            	//if user already has appointment in future
			            			            	if (e.status == 412){
			            			            		showMessageDialog("Error",'You already have an scheduled apointment');
			            			            	}
			            			            	else{
			            			            		console.log(e);
			            								showMessageDialog("Error",'there was an error while confirming appointment!');
			            			            	}
			            						}
			            			        });
			                        },
			                        CANCEL: function(){
			                        	$("#dialog").dialog( "close" );
			                        }
			                        
			                      }
			        });
			    	 
			    }
		    }
			
		
		});
	});
</script>


</head>

<body>
	<div id="appointment-container">
		<div id="doctors-list">
			<s:select id="doctor-select" list="doctors" cssClass="form-control" value="%{id}" listKey="id"
				onchange="refetchAppointments()">
			</s:select>
		</div>
		<div id='calendar'></div>
	</div>
	<div id="dialog" style="display: none;"></div>
</body>
</html>