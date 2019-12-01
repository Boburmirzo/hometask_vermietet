**viermietet**

* **URL**

  <_ /counter_callback/_>

* **Method:**

  <_POST_>


*  **URL Params**

   **Required:**

   `id=[integer]`
   `amount=[double]`

  * **Data Params**

  {
  	"id":"1",
  	"amount":"0.12"
  }

* **Success Response:**

  * **Code:** 201 <br />


* **Error Response:**

   * **Code:** 417 EXPECTATION_FAIL <br />
    Check the validity of body parameters

  OR

  * **Code:** 500 INTERANL SERVER ERROR <br />

* **Sample Call:**
    From any REST Client or use curl.
  <_http://localhost:8080/counter_callback_>

* **URL**

  <_ /counter?id=_>

* **Method:**

  <_GET_>


*  **URL Params**

   **Required:**

   `id=[integer]`

  * **Data Params**

* **Success Response:**

  * **Code:** 200 <br />


* **Error Response:**

   * **Code:** 404 NOT_FOUND <br />
    The device id does not exist

  OR

  * **Code:** 500 INTERANL SERVER ERROR <br />
  <_Content : Counter does not exists_>

* **Sample Call:**
    From any REST Client or use curl.
  <_http://localhost:8080/counter?id=1_>

  * **URL**

    <_ /consumption_report?duration=_>

  * **Method:**

    <_GET_>


  *  **URL Params**

     **Required:**

     `duration=[integer]`

    * **Data Params**

  * **Success Response:**

    * **Code:** 200 <br />


  * **Error Response:**

    * **Code:** 500 INTERANL SERVER ERROR <br />


  * **Sample Call:**
      From any REST Client or use curl.
    <_http://localhost:8080/consumption_report?duration=24_>
