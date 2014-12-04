jQuery(function($){
        $.datepicker.regional['ua'] = {
                closeText: 'Закрыть',
                prevText: '&#x3c;Поперед',
                nextText: 'Наст&#x3e;',
                currentText: 'Сьогодня',
                monthNames: ['Січень','Лютий','Березень','Квітень','Травень','Червень',
                'Липень','Серпень','Вересень','Жовтень','Листопад','Грудень'],
                monthNamesShort: ['Січ','Лют','Бер','Квіт','Трав','Черв',
                'Лип','Сер','Вер','Жовт','Лист','Груд'],
                dayNames: ['неділя','понеділок','вівторок','середа','четвер','п\'ятница','субота'],
                dayNamesShort: ['вск','пнд','втр','срд','чтв','птн','сбт'],
                dayNamesMin: ['Вс','Пн','Вт','Ср','Чт','Пт','Сб'],
                weekHeader: 'Не',
                dateFormat: 'dd.mm.yy',
                firstDay: 1,
                isRTL: false,
                showMonthAfterYear: false,
                yearSuffix: ''};
        $.datepicker.setDefaults(
        	$.datepicker.regional['ua']);
       
    
});