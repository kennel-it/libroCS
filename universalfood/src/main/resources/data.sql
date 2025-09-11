insert into menu (id, nazione, nome, descrizione) values
(1, 'Giappone', 'Sapori dal Sol Levante', 'La cucina giapponese si basa sull’equilibrio tra estetica, stagionalità e sapori delicati. È ricca di piatti che valorizzano pesce fresco, riso, verdure e brodi, con grande attenzione alla presentazione. Ogni piatto racconta una parte della cultura: dalla raffinatezza dei sushi bar al comfort food delle zuppe calde.'),
(2, 'Messico', 'Colori e Fuoco del Messico', 'La cucina messicana è vivace e speziata, con ingredienti come mais, fagioli, peperoncini e avocado. È patrimonio dell’UNESCO grazie alla sua varietà e radici antiche, che uniscono tradizioni indigene e influenze spagnole.'),
(3, 'India', 'Viaggio tra Spezie Indiane', 'La cucina indiana è una festa di colori, aromi e spezie. Ogni regione ha tradizioni uniche, ma in tutto il paese prevalgono piatti profumati a base di curry, legumi e riso. È anche ricca di opzioni vegetariane.'),
(4, 'Grecia', 'Tradizione e Mare dell’Egeo', 'La cucina greca unisce ingredienti mediterranei come olio d’oliva, verdure fresche, legumi e carne alla griglia. È semplice ma gustosa, con piatti conviviali che riflettono la vita sociale del paese.'),
(5, 'Marocco', 'Profumi del Deserto Marocchino', 'La cucina marocchina combina spezie profumate, cotture lente e sapori dolce-salati. È conviviale e spesso servita in grandi piatti da condividere.');

insert into piatto(id,menu_id,nome,costo,disponibile,descrizione) values
(11, 1, 'Sushi', 14.00, true, 'Riso condito con aceto, abbinato a pesce crudo o cotto, verdure o uova. Elegante e leggero, è simbolo della cucina giapponese.'),
(12, 1, 'Ramen', 6.00, true, 'Zuppa di noodles servita in brodo ricco (pollo e miso), con carne, uova e verdure. Piatto nutriente e confortante.'),
(13, 1, 'Tempura', 9.00, true, 'Verdure o frutti di mare fritti in pastella leggera. Croccantezza e leggerezza convivono in un piatto raffinato.'),
(14, 1, 'Okonomiyaki', 7.00, false, 'Pancake salato con cavolo, uova e carne/pesce, cotto su piastra e condito con salsa, maionese e alghe. Personalizzabile.');

insert into piatto(id,menu_id,nome,costo,disponibile,descrizione) values
(21, 2, 'Tacos', 8.00, true, 'Tortillas morbide o croccanti ripiene di carne e verdure, guarnite con salse piccanti. Street food simbolo del Messico.'),
(22, 2, 'Enchiladas', 12.00, true, 'Tortillas arrotolate con ripieno di carne, ricoperte di salsa piccante e cotte al forno. Sostanziose e gustose.'),
(23, 2, 'Guacamole', 8.00, true, 'Crema a base di avocado schiacciato, lime, cipolla e coriandolo. Fresca e versatile, accompagna nachos.'),
(24, 2, 'Pollo con Mole poblano', 13.00, false, 'Salsa complessa con cioccolato, spezie e peperoncini, servita su pollo. Dolce, piccante e profonda nei sapori.');

insert into piatto(id,menu_id,nome,costo,disponibile,descrizione) values
(31, 3, 'Chicken tikka masala', 11.00, true, 'Pollo marinato e grigliato, servito in salsa cremosa e speziata al pomodoro. Equilibrio tra piccante e dolce.'),
(32, 3, 'Samosa', 6.00, true, 'Fagottini fritti triangolari ripieni di patate. Croccanti, speziati e perfetti come snack o antipasto.'),
(33, 3, 'Biryani', 15.00, true, 'Riso profumato cotto con spezie, carne e verdure. Piatto unico, aromatico e celebrativo'),
(34, 3, 'Dal', 7.00, true, 'Zuppa di lenticchie speziata, base della cucina indiana quotidiana. Nutriente, semplice ma ricca di sapore.');

insert into piatto(id,menu_id,nome,costo,disponibile,descrizione) values
(41, 4, 'Moussaka', 12.00, true, 'Sformato a strati con melanzane, carne macinata e besciamella. Ricco e confortante, simile a una lasagna.'),
(42, 4, 'Souvlaki', 16.00, true, 'Spiedini di carne marinata e grigliata, serviti con pita e contorni freschi. Popolare e saporito.'),
(43, 4, 'Tzatziki', 6.00, true, 'Salsa rinfrescante a base di yogurt greco, cetriolo e aglio. Servita con crostini.'),
(44, 4, 'Spanakopita', 8.00, true, 'Torta salata di pasta fillo ripiena di spinaci e feta. Croccante fuori, morbida dentro.');

insert into piatto(id,menu_id,nome,costo,disponibile,descrizione) values
(51, 5, 'Couscous', 12.00, true, 'Semola cotta a vapore, servita con verdure e carne. È il piatto nazionale, nutriente e versatile.'),
(52, 5, 'Tajine', 12.00, true, 'Stufato cotto lentamente nell’omonimo recipiente di terracotta. Carne, verdure e spezie si fondono armoniosamente.'),
(53, 5, 'Harira', 8.00, true, 'Zuppa ricca di legumi, pomodori e spezie, spesso consumata durante il Ramadan. Calda e nutriente.'),
(54, 5, 'Pastilla', 13.00, false, 'Torta salata dolce-salata con carne (piccione), mandorle e zucchero a velo. Sorprendente e complessa.');