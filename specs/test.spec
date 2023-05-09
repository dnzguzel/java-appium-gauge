Selendroid Apk Test Cases
=====================
Created by denizg on 7.05.2023

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
table: RegisterUserData.csv

## EN Butonuna No ile devam edilmesi
Tags:test1
* Click to EN Button
* Click to Android No Button
* Verify visibility of EN Button

## Reqister Multiple New User
Tags:test2
* Click to Register New user Button
* Type <username> to username field.
* Type <email> to email field.
* Type <password> to password field.
* Clear and type <name> to name field.
* Click to programming language.
* Select to <language> programming language.
* Reklamları kabul ediyor musun? true/false <acceptAdds>
* Click to Register User(verify) button.
* Name should be <name> on register screen.
* Username should be <username> on register screen.
* Email should be <email> on register screen.
* Preferred language should be <language> on register screen.
* I accept adds should be <acceptAdds> on register screen.
* Click to registered button.

## Test mouse actions
Tags:test3
* Click to TouchTest button.
* Only one click on the screen.
* Screen message should be "SINGLE TAP CONFIRMED".
* Wait "2" seconds
* Long press on the screen.
* Screen message should be "LONG PRESS".

## Message control after click to button
Tags:test4
* Display text view butonuna tıklandıktan sonra çıkan mesaj "Text is sometimes displayed" olmalı