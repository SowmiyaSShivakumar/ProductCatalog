import smtplib
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText

# Configuration
SMTP_SERVER = 'smtp.your_email_provider.com'
SMTP_PORT = 587
USERNAME = 'your_email@example.com'
PASSWORD = 'your_password'

# Email Details
def send_email(to_address, subject, body):
    msg = MIMEMultipart()
    msg['From'] = USERNAME
    msg['To'] = to_address
    msg['Subject'] = subject
    msg.attach(MIMEText(body, 'plain'))

    with smtplib.SMTP(SMTP_SERVER, SMTP_PORT) as server:
        server.starttls()  # Upgrade to a secure connection
        server.login(USERNAME, PASSWORD)
        server.send_message(msg)

# Sending the report
recipient = 'ishwarya.ms@prodapt.com'
subject = 'Evaluation Report for ProductCatalog Repository'
body = 'The comprehensive evaluation report for the ProductCatalog repository has been generated and is attached.'

send_email(recipient, subject, body)