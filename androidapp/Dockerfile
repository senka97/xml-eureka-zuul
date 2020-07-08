FROM python:3
COPY location_script.py ./
RUN pip install pika --upgrade
CMD sh -c "sleep 120s && python location_script.py"
