<div style="font-family: Arial, Helvetica, sans-serif; line-height: 1.5; color: #1f2937;">

<h1 style="font-size: 36px; font-weight: 800; margin-bottom: 10px;">
Job Application Microservices Platform
</h1>

<p style="font-size: 16px; max-width: 900px;">
A production-style <b>Spring Boot microservices backend</b> for a Job Application system, designed using real-world backend architecture patterns, containerization, and Kubernetes-based deployment.
</p>

<hr/>

<h2 style="font-size: 26px; font-weight: 700; margin-top: 30px;">
What this project is about
</h2>

<p>
This project models the backend of a job portal system using a microservices architecture. The platform is centered around three core business services: <b>Company</b>, <b>Job</b>, and <b>Review</b>. These services are supported by shared infrastructure components such as an API Gateway, Service Registry, Config Server, messaging system, and distributed tracing.
</p>

<p>
The focus of this project is not just CRUD APIs, but <b>scalability, resilience, configuration management, and real deployment practices</b>.
</p>

<hr/>

<h2 style="font-size: 26px; font-weight: 700; margin-top: 30px;">
Core services
</h2>

<ul>
  <li><b>CompanyAppService</b> – Manages company information</li>
  <li><b>JobAppService</b> – Manages job postings and links them to companies</li>
  <li><b>ReviewAppService</b> – Manages company reviews and ratings</li>
</ul>

<h3 style="font-size: 20px; font-weight: 700;">
Infrastructure services
</h3>

<ul>
  <li>API Gateway (Spring Cloud Gateway)</li>
  <li>Service Registry (Eureka)</li>
  <li>Config Server (centralized configuration)</li>
  <li>RabbitMQ (asynchronous messaging)</li>
  <li>PostgreSQL (persistence)</li>
  <li>Zipkin (distributed tracing)</li>
</ul>

<hr/>

<h2 style="font-size: 26px; font-weight: 700; margin-top: 30px;">
Tech stack
</h2>

<p>
<b>Java 17, Spring Boot, Spring Cloud (Eureka, Gateway, Config Server), Spring Data JPA, Resilience4j, RabbitMQ, PostgreSQL, Docker, Docker Compose, Kubernetes, Zipkin, Maven</b>
</p>

<hr/>

<h2 style="font-size:26px;font-weight:700;margin-top:30px;">
Architecture Overview
</h2>

<p>
The system follows a layered microservices architecture with a single entry point, service discovery, centralized configuration, asynchronous messaging, and containerized deployment.
</p>

<table style="width:100%;border-collapse:collapse;text-align:center;">
  <tr>
    <td style="border:2px solid #111827;padding:12px;border-radius:8px;font-weight:600;">
      Clients<br/>
      <span style="font-size:13px;">Web / Mobile</span>
    </td>
    <td style="font-size:22px;">→</td>
    <td style="border:2px solid #111827;padding:12px;border-radius:8px;font-weight:600;">
      API Gateway<br/>
      <span style="font-size:13px;">Routing · Filters</span>
    </td>
    <td style="font-size:22px;">→</td>
    <td style="border:2px solid #111827;padding:12px;border-radius:8px;font-weight:600;">
      Microservices<br/>
      <span style="font-size:13px;">Company · Job · Review</span>
    </td>
  </tr>
</table>

<br/>

<table style="width:100%;border-collapse:collapse;text-align:center;">
  <tr>
    <td style="border:1.8px solid #374151;padding:10px;border-radius:8px;">
      <b>Eureka</b><br/>
      <span style="font-size:13px;">Service Discovery</span>
    </td>
    <td style="border:1.8px solid #374151;padding:10px;border-radius:8px;">
      <b>Config Server</b><br/>
      <span style="font-size:13px;">Centralized Configuration</span>
    </td>
    <td style="border:1.8px solid #374151;padding:10px;border-radius:8px;">
      <b>RabbitMQ</b><br/>
      <span style="font-size:13px;">Async Messaging</span>
    </td>
    <td style="border:1.8px solid #374151;padding:10px;border-radius:8px;">
      <b>PostgreSQL</b><br/>
      <span style="font-size:13px;">Persistence</span>
    </td>
    <td style="border:1.8px solid #374151;padding:10px;border-radius:8px;">
      <b>Zipkin</b><br/>
      <span style="font-size:13px;">Tracing</span>
    </td>
  </tr>
</table>

<p style="margin-top:12px;">
Client requests enter through the <b>API Gateway</b>, which routes traffic to the appropriate microservice. Services discover each other via <b>Eureka</b>, load configuration from the <b>Config Server</b>, communicate asynchronously using <b>RabbitMQ</b>, persist data in <b>PostgreSQL</b>, and publish traces to <b>Zipkin</b>. The entire system is containerized with Docker and orchestrated using Kubernetes.
</p>

<h2 style="font-size: 26px; font-weight: 700; margin-top: 30px;">
Docker and Kubernetes
</h2>

<p>
The project supports both <b>Docker Compose</b> for local development and a complete <b>Kubernetes setup</b> for production-style deployment. Kubernetes manifests include Deployments, Services, ConfigMaps, Secrets (base64 encoded), StatefulSets for PostgreSQL, and infrastructure components like RabbitMQ and Zipkin.
</p>

<hr/>

<h2 style="font-size: 26px; font-weight: 700; margin-top: 30px;">
Why this project stands out
</h2>

<ul>
  <li>Real microservices architecture with service discovery</li>
  <li>Centralized configuration using Config Server</li>
  <li>Resilience using circuit breakers</li>
  <li>Asynchronous communication with RabbitMQ</li>
  <li>Production-style Docker and Kubernetes deployment</li>
</ul>

<hr/>

<h2 style="font-size: 26px; font-weight: 700; margin-top: 30px;">
Author
</h2>

<p>
<b>Rahul Agarwal</b><br/>
Backend Developer | Java | Spring Boot | Microservices<br/>
GitHub: <a href="https://github.com/Rahu0909">https://github.com/Rahu0909</a>
</p>

</div>
