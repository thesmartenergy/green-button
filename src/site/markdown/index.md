# Green-Button SPARQL-Generate queries

This site exposes the SPARQL-Generate queries to interpret Green Button outputs with the SEAS ontologies.

# Implementation of Green-Button that uses the SPARQL-Generate protocol

This software fully supports OpenADR and Green Button standards. One can either use this implementation as a classic Green Button Data Custodian, or use it as a "proxy" to make an existent database fully compatible with the SEAS knowledge representation model.

# Examples

This is a very simple example, it requests all present usagePoints on a given data custodian. Header fields ask for a "semantic" response.

**Client request:**

```
GET http://127.0.0.1:8080/GreenButton/UsagePoint
```

with these two header fields:

```
Content-Type:application/xml
Accept:application/sparql-generate
```

**Server answer:**

Header fields:
```
Link:<http://127.0.0.1:8080/GreenButton/query/UsagePoints>; rel="spargl-query"; var="message"
```

Body:
```
<?xml version="1.0" encoding="UTF-8" standalone="no" ?>
<atom:feed xmlns:atom="http://www.w3.org/2005/Atom" xmlns:espi="http://naesb.org/espi" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.w3.org/2005/Atom ../xsd/oadr_atom.xsd">
  <atom:entry>
    <atom:content>
      <espi:UsagePoint xmlns:atom="http://www.w3.org/2005/Atom" xmlns:espi="http://naesb.org/espi" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.w3.org/2005/Atom ../xsd/oadr_atom.xsd">
        <espi:ServiceCategory>
          <espi:kind>0</espi:kind>
        </espi:ServiceCategory>
        <espi:status>0</espi:status>
      </espi:UsagePoint>
    </atom:content>
    <atom:id>c8c34b3a-d175-547b-be00-1726601943e0</atom:id>
    <atom:link href="http://127.0.0.1:8080/GreenButton/Resource/RetailCustomer/1/UsagePoint/2" rel="self"/>
    <atom:link href="http://127.0.0.1:8080/GreenButton/Resource/RetailCustomer/1/UsagePoint" rel="up"/>
    <atom:link href="http://127.0.0.1:8080/GreenButton/Resource/RetailCustomer/1/UsagePoint/2/MeterReading" rel="related"/>
    <atom:link href="http://127.0.0.1:8080/GreenButton/Resource/LocalTimeParameters/1" rel="related"/>
    <atom:published>2013-09-19T04:00:00</atom:published>
    <atom:updated>2013-09-19T04:00:00</atom:updated>
  </atom:entry>
  <atom:entry>
    <atom:content>
      <espi:UsagePoint xmlns:atom="http://www.w3.org/2005/Atom" xmlns:espi="http://naesb.org/espi" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.w3.org/2005/Atom ../xsd/oadr_atom.xsd">
        <espi:ServiceCategory>
          <espi:kind>0</espi:kind>
        </espi:ServiceCategory>
        <espi:status>0</espi:status>
        <espi:ServiceDeliveryPoint>
          <espi:name>sample tariff showing block and tier pricing</espi:name>
          <espi:tariffProfile>./TariffSample.xml</espi:tariffProfile>
          <espi:customerAgreement/>
        </espi:ServiceDeliveryPoint>
      </espi:UsagePoint>
    </atom:content>
    <atom:id>e2dcf5f0-810b-443f-9a2e-805bfa52d897</atom:id>
    <atom:link href="http://127.0.0.1:8080/GreenButton/Resource/RetailCustomer/2/UsagePoint/1" rel="self"/>
    <atom:link href="http://127.0.0.1:8080/GreenButton/Resource/RetailCustomer/2/UsagePoint" rel="up"/>
    <atom:link href="http://127.0.0.1:8080/GreenButton/Resource/RetailCustomer/2/UsagePoint/1/MeterReading" rel="related"/>
    <atom:link href="http://127.0.0.1:8080/GreenButton/Resource/RetailCustomer/2/UsagePoint/1/ElectricPowerUsageSummary" rel="related"/>
    <atom:link href="http://127.0.0.1:8080/GreenButton/Resource/LocalTimeParameters/1" rel="related"/>
    <atom:published>2013-09-19T04:00:00</atom:published>
    <atom:updated>2013-09-19T04:00:00</atom:updated>
  </atom:entry>
</atom:feed>
```

# Working server

A server is running for SEAS pilots, ask who for obtaining an access.

# Contribute to this site

Do not hesitate to propose examples, additions, report bugs, or just say hello:

- The issue tracker - http://github.com/thesmartenergy/green-button/issues
